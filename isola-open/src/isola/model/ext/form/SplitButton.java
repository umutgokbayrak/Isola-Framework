package isola.model.ext.form;
 * // display a dropdown menu:
 * new Ext.SplitButton({
 * 	renderTo: 'button-ct', // the container id
 *    	text: 'Options',
 *    	handler: optionsHandler, // handle a click on the button itself
 *    	menu: new Ext.menu.Menu({
 *         items: [
 *         	// these items will render as dropdown menu items when the arrow is clicked:
 * 	        {text: 'Item 1', handler: item1Handler},
 * 	        {text: 'Item 2', handler: item2Handler},
 *         ]
 *    	})
 * });
 * 
 * // Instead of showing a menu, you provide any type of custom
 * // functionality you want when the dropdown arrow is clicked:
 * new Ext.SplitButton({
 * 	renderTo: 'button-ct',
 *    	text: 'Options',
 *    	handler: optionsHandler,
 *    	arrowHandler: myCustomHandler
 * });
 * &lt;/code&gt;