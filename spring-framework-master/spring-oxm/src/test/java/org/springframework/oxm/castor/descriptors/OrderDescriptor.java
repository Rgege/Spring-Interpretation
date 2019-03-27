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
import org.springframework.oxm.castor.Order;
import org.springframework.oxm.castor.OrderItem;

public class OrderDescriptor extends XMLClassDescriptorImpl {
	private boolean _elementDefinition = true;
	private String _nsPrefix;
	private String _nsURI = "http://samples.springframework.org/order";
	private String _xmlName = "order";
	private XMLFieldDescriptor _identity;

	public OrderDescriptor() {
		this.setCompositorAsSequence();
		XMLFieldDescriptorImpl desc = null;
		FieldHandler handler = null;
		FieldValidator fieldValidator = null;
		desc = new XMLFieldDescriptorImpl(OrderItem.class, "orderItemList", "order-item", NodeType.Element);
		handler = new XMLFieldHandler() {
			public Object getValue(Object object) throws IllegalStateException {
				Order target = (Order)object;
				return target.getOrderItem();
			}

			public void setValue(Object object, Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					Order target = (Order)object;
					target.addOrderItem((OrderItem)value);
				} catch (Exception var4) {
					throw new IllegalStateException(var4.toString());
				}
			}

			public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
				try {
					Order target = (Order)object;
					target.removeAllOrderItem();
				} catch (Exception var3) {
					throw new IllegalStateException(var3.toString());
				}
			}

			public Object newInstance(Object parent) {
				return new OrderItem();
			}
		};
		desc.setSchemaType("list");
		desc.setComponentType("org.springframework.oxm.castor.OrderItem");
		desc.setHandler(handler);
		desc.setNameSpaceURI("http://samples.springframework.org/order");
		desc.setRequired(true);
		desc.setMultivalued(true);
		this.addFieldDescriptor(desc);
		this.addSequenceElement(desc);
		fieldValidator = new FieldValidator();
		fieldValidator.setMinOccurs(1);
		desc.setValidator(fieldValidator);
	}

	public AccessMode getAccessMode() {
		return null;
	}

	public FieldDescriptor getIdentity() {
		return this._identity;
	}

	public Class getJavaClass() {
		return Order.class;
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
