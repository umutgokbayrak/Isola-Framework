package isola.model.ext.toolbar;
 * new Ext.Panel({
 * 	tbar : [
 * 		{
 * 			xtype: 'tbsplit',
 * 		   	text: 'Options',
 * 		   	handler: optionsHandler, // handle a click on the button itself
 * 		   	menu: new Ext.menu.Menu({
 * 		        items: [
 * 		        	// These items will display in a dropdown menu when the split arrow is clicked
 * 			        {text: 'Item 1', handler: item1Handler},
 * 			        {text: 'Item 2', handler: item2Handler},
 * 		        ]
 * 		   	})
 * 		}
 * 	]
 * });
 * &lt;/code&gt;