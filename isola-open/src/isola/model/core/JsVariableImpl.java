package isola.model.core;/** * @author Umut Gokbayrak */public class JsVariableImpl implements JsVariable {	private String value;		public JsVariableImpl() {		super();	}		public JsVariableImpl(String value) {		super();		this.value = value;	}		public String getValue() {		return value;	}		public void setValue(String value) {		this.value = value;	}		@Override	public String toString() {		return value;	}}