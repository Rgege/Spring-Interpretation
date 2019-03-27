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
import org.exolab.castor.xml.validators.IntValidator;
import org.exolab.castor.xml.validators.StringValidator;
import org.springframework.oxm.castor.OrderItemType;

public class OrderItemTypeDescriptor extends XMLClassDescriptorImpl {
	private boolean _elementDefinition = false;
	private String _nsPrefix;
	private String _nsURI = "http://samples.springframework.org/order";
	private String _xmlName = "orderItemType";
	private XMLFieldDescriptor _identity;

	public OrderItemTypeDescriptor() {
		XMLFieldDescriptorImpl desc = null;
		FieldHandler handler = null;
		FieldValidator fieldValidator = null;
		desc = new XMLFieldDescriptorImpl(String.class, "id", "id", NodeType.Attribute);
		desc.setImmutable(true);
		handler = new XMLFieldHandler() {
			public Object getValue(Object object) throws IllegalStateException {
				OrderItemType target = (OrderItemType)object;
				return target.getId();
			}

			public void setValue(Object object, Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					OrderItemType target = (OrderItemType)object;
					target.setId((String)value);
				} catch (Exception var4) {
					throw new IllegalStateException(var4.toString());
				}
			}

			public Object newInstance(Object parent) {
				return null;
			}
		};
		desc.setSchemaType("string");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		this.addFieldDescriptor(desc);
		fieldValidator = new FieldValidator();
		StringValidator typeValidator = new StringValidator();
		fieldValidator.setValidator(typeValidator);
		typeValidator.setWhiteSpace("preserve");
		desc.setValidator(fieldValidator);
		desc = new XMLFieldDescriptorImpl(Integer.TYPE, "quantity", "quantity", NodeType.Attribute);
		handler = new XMLFieldHandler() {
			public Object getValue(Object object) throws IllegalStateException {
				OrderItemType target = (OrderItemType)object;
				return !target.hasQuantity() ? null : new Integer(target.getQuantity());
			}

			public void setValue(Object object, Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					OrderItemType target = (OrderItemType)object;
					if (value == null) {
						target.deleteQuantity();
					} else {
						target.setQuantity((Integer)value);
					}
				} catch (Exception var4) {
					throw new IllegalStateException(var4.toString());
				}
			}

			public Object newInstance(Object parent) {
				return null;
			}
		};
		desc.setSchemaType("int");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		this.addFieldDescriptor(desc);
		fieldValidator = new FieldValidator();
		IntValidator typeValidator1 = new IntValidator();
		fieldValidator.setValidator(typeValidator);
		typeValidator1.setMinInclusive(-2147483648);
		typeValidator1.setMaxInclusive(2147483647);
		desc.setValidator(fieldValidator);
	}

	public AccessMode getAccessMode() {
		return null;
	}

	public FieldDescriptor getIdentity() {
		return this._identity;
	}

	public Class getJavaClass() {
		return OrderItemType.class;
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
