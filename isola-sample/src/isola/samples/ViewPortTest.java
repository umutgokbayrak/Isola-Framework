package isola.samples;import isola.model.core.JsArray;import isola.model.ext.container.BoxComponent;import isola.model.ext.container.ViewPort;import isola.model.ext.form.Button;import junit.framework.TestCase;public class ViewPortTest extends TestCase {	public void testToString() {		JsArray arr = new JsArray();		arr.add(new Button());		arr.add(new BoxComponent());		ViewPort vp = new ViewPort();		vp.id = "deneme";		vp.autoDestroy = true;		vp.items = arr;		System.out.println(vp.toString());	}}