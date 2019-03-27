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
import org.springframework.oxm.castor.Flight;
import org.springframework.oxm.castor.Flights;

public class FlightsDescriptor extends XMLClassDescriptorImpl {
	private boolean _elementDefinition = true;
	private String _nsPrefix;
	private String _nsURI = "http://samples.springframework.org/flight";
	private String _xmlName = "flights";
	private XMLFieldDescriptor _identity;

	public FlightsDescriptor() {
		this.setCompositorAsSequence();
		XMLFieldDescriptorImpl desc = null;
		FieldHandler handler = null;
		FieldValidator fieldValidator = null;
		desc = new XMLFieldDescriptorImpl(Flight.class, "flightList", "flight", NodeType.Element);
		handler = new XMLFieldHandler() {
			public Object getValue(Object object) throws IllegalStateException {
				Flights target = (Flights)object;
				return target.getFlight();
			}

			public void setValue(Object object, Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					Flights target = (Flights)object;
					target.addFlight((Flight)value);
				} catch (Exception var4) {
					throw new IllegalStateException(var4.toString());
				}
			}

			public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
				try {
					Flights target = (Flights)object;
					target.removeAllFlight();
				} catch (Exception var3) {
					throw new IllegalStateException(var3.toString());
				}
			}

			public Object newInstance(Object parent) {
				return new Flight();
			}
		};
		desc.setSchemaType("list");
		desc.setComponentType("org.springframework.oxm.castor.Flight");
		desc.setHandler(handler);
		desc.setNameSpaceURI("http://samples.springframework.org/flight");
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
		return Flights.class;
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
