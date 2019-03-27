//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.oxm.castor.descriptors;

import org.exolab.castor.mapping.AccessMode;
import org.exolab.castor.mapping.FieldDescriptor;
import org.exolab.castor.mapping.FieldHandler;
import org.exolab.castor.xml.FieldValidator;
import org.exolab.castor.xml.NodeType;
import org.exolab.castor.xml.TypeValidator;
import org.exolab.castor.xml.XMLFieldDescriptor;
import org.exolab.castor.xml.XMLFieldHandler;
import org.exolab.castor.xml.util.XMLClassDescriptorImpl;
import org.exolab.castor.xml.util.XMLFieldDescriptorImpl;
import org.exolab.castor.xml.validators.LongValidator;
import org.springframework.oxm.castor.FlightType;

public class FlightTypeDescriptor extends XMLClassDescriptorImpl {
	private boolean _elementDefinition = false;
	private String _nsPrefix;
	private String _nsURI = "http://samples.springframework.org/flight";
	private String _xmlName = "flightType";
	private XMLFieldDescriptor _identity;

	public FlightTypeDescriptor() {
		this.setCompositorAsSequence();
		XMLFieldDescriptorImpl desc = null;
		FieldHandler handler = null;
		FieldValidator fieldValidator = null;
		desc = new XMLFieldDescriptorImpl(Long.TYPE, "number", "number", NodeType.Element);
		handler = new XMLFieldHandler() {
			public Object getValue(Object object) throws IllegalStateException {
				FlightType target = (FlightType)object;
				return !target.hasNumber() ? null : new Long(target.getNumber());
			}

			public void setValue(Object object, Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					FlightType target = (FlightType)object;
					if (value != null) {
						target.setNumber((Long)value);
					}
				} catch (Exception var4) {
					throw new IllegalStateException(var4.toString());
				}
			}

			public Object newInstance(Object parent) {
				return null;
			}
		};
		desc.setSchemaType("long");
		desc.setHandler(handler);
		desc.setNameSpaceURI("http://samples.springframework.org/flight");
		desc.setRequired(true);
		desc.setMultivalued(false);
		this.addFieldDescriptor(desc);
		this.addSequenceElement(desc);
		fieldValidator = new FieldValidator();
		fieldValidator.setMinOccurs(1);
		LongValidator typeValidator = new LongValidator();
		fieldValidator.setValidator(typeValidator);
		typeValidator.setMinInclusive(-9223372036854775808L);
		typeValidator.setMaxInclusive(9223372036854775807L);
		desc.setValidator(fieldValidator);
	}

	public AccessMode getAccessMode() {
		return null;
	}

	public FieldDescriptor getIdentity() {
		return this._identity;
	}

	public Class getJavaClass() {
		return FlightType.class;
	}

	public String getNameSpacePrefix() {
		return this._nsPrefix;
	}

	public String getNameSpaceURI() {
		return this._nsURI;
	}

	public TypeValidator getValidator() {
		return this;
	}

	public String getXMLName() {
		return this._xmlName;
	}

	public boolean isElementDefinition() {
		return this._elementDefinition;
	}
}
