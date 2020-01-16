/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.security.servlet;

import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.StaticWebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Tests for {@link ApplicationContextRequestMatcher}.
 *
 * @author Phillip Webb
 */
class ApplicationContextRequestMatcherTests {

	@Test
	void createWhenContextClassIsNullShouldThrowException() {
		assertThatIllegalArgumentException().isThrownBy(() -> new TestApplicationContextRequestMatcher<>(null))
				.withMessageContaining("Context class must not be null");
	}

	@Test
	void matchesWhenContextClassIsApplicationContextShouldProvideContext() {
		StaticWebApplicationContext context = createWebApplicationContext();
		assertThat(new TestApplicationContextRequestMatcher<>(ApplicationContext.class)
				.callMatchesAndReturnProvidedContext(context).get()).isEqualTo(context);
	}

	@Test
	void matchesWhenContextClassIsExistingBeanShouldProvideBean() {
		StaticWebApplicationContext context = createWebApplicationContext();
		context.registerSingleton("existingBean", ExistingBean.class);
		assertThat(new TestApplicationContextRequestMatcher<>(ExistingBean.class)
				.callMatchesAndReturnProvidedContext(context).get()).isEqualTo(context.getBean(ExistingBean.class));
	}

	@Test
	void matchesWhenContextClassIsBeanThatDoesNotExistShouldSupplyException() {
		StaticWebApplicationContext context = createWebApplicationContext();
		Supplier<ExistingBean> supplier = new TestApplicationContextRequestMatcher<>(ExistingBean.class)
				.callMatchesAndReturnProvidedContext(context);
		assertThatExceptionOfType(NoSuchBeanDefinitionException.class).isThrownBy(supplier::get);
	}

	private StaticWebApplicationContext createWebApplicationContext() {
		StaticWebApplicationContext context = new StaticWebApplicationContext();
		MockServletContext servletContext = new MockServletContext();
		context.setServletContext(servletContext);
		servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
		return context;
	}

	static class ExistingBean {

	}

	static class NewBean {

		private final ExistingBean bean;

		NewBean(ExistingBean bean) {
			this.bean = bean;
		}

		ExistingBean getBean() {
			return this.bean;
		}

	}

	static class TestApplicationContextRequestMatcher<C> extends ApplicationContextRequestMatcher<C> {

		private Supplier<C> providedContext;

		TestApplicationContextRequestMatcher(Class<? extends C> context) {
			super(context);
		}

		Supplier<C> callMatchesAndReturnProvidedContext(WebApplicationContext context) {
			return callMatchesAndReturnProvidedContext(new MockHttpServletRequest(context.getServletContext()));
		}

		Supplier<C> callMatchesAndReturnProvidedContext(HttpServletRequest request) {
			matches(request);
			return getProvidedContext();
		}

		@Override
		protected boolean matches(HttpServletRequest request, Supplier<C> context) {
			this.providedContext = context;
			return false;
		}

		Supplier<C> getProvidedContext() {
			return this.providedContext;
		}

	}

}