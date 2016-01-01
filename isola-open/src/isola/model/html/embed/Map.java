package isola.model.html.embed;import isola.helpers.ElementParserHtml;import isola.model.html.core.Container;/** *  *  *  * @author Umut Gokbayrak *  *  */public class Map extends Container {	private static final String tag = "map";	/**	 * 	 * This attribute assigns the control name.	 */	private String name;		public Map() {		super();		setId(tag + (Math.random() * 1000));	}		public Map(String id) {		super(id);	}		public Map(String id, String name) {		super(id);		setName(name);	}		public String getName() {		return name;	}		/**	 * 	 * This attribute assigns the control name.	 * 	 * 	 * 	 * @param name	 */	public void setName(String name) {		this.name = name;	}		@Override	public String toString() {		return ElementParserHtml.getToStringOut(this);	}		public String getTag() {		return tag;	}}