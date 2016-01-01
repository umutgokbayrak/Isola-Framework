package isola.model.ext.form;
	 * // Apply a style to the field's label:
	 * &lt;style&gt;
	 *     .required .x-form-item-label {font-weight:bold;color:red;}
	 * &lt;/style&gt;
	 * 
	 * new Ext.FormPanel({
	 * 	height: 100,
	 * 	renderTo: document.body,
	 * 	items: [{
	 * 		xtype: 'textfield',
	 * 		fieldLabel: 'Name',
	 * 		itemCls: 'required' //this label will be styled
	 * 	},{
	 * 		xtype: 'textfield',
	 * 		fieldLabel: 'Favorite Color'
	 * 	}]
	 * });
	 * &lt;/code&gt;
	 * -----------   ----------------------------------------------------------------------
	 * qtip          Display a quick tip when the user hovers over the field
	 * title         Display a default browser title attribute popup
	 * under         Add a block div beneath the field containing the error text
	 * side          Add an error icon to the right of the field with a popup on hover
	 * [element id]  Add the error text directly to the innerHTML of the specified element