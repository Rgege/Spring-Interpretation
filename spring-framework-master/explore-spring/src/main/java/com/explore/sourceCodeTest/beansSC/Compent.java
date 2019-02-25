/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.explore.sourceCodeTest.beansSC;

import org.springframework.stereotype.Component;

/**
 * Compent
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/2/22
 **/
@Component
public class Compent {
	private String s;
	private Integer i;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		System.out.println("==============================="+i);
		this.i = i;
	}
}
