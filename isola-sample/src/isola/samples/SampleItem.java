package isola.samples;/** *  * Sample class to carry data to be serialized *  *  *  * @author TCUGOKBAYRAK *  *  */public class SampleItem {	private String name;	private String value;		public SampleItem(String name, String value) {		this.name = name;		this.value = value;	}		public String getName() {		return name;	}		public void setName(String name) {		this.name = name;	}		public String getValue() {		return value;	}		public void setValue(String value) {		this.value = value;	}}