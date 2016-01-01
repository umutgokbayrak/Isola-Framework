package isola.model.html.phrase;import isola.helpers.ElementParserHtml;import isola.model.html.core.Container;/** *  * Indicates text to be entered by the user. *  *  *  * @author Umut Gokbayrak */public class Kbd extends Container {	private static final String tag = "kbd";		public Kbd() {		super();		setId(tag + (Math.random() * 1000));	}		public Kbd(String id) {		super(id);	}		@Override	public String toString() {		return ElementParserHtml.getToStringOut(this);	}		public String getTag() {		return tag;	}}