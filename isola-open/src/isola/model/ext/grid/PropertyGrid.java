package isola.model.ext.grid;
	 * var grid = new Ext.grid.PropertyGrid({
	 *     ...
	 *     customEditors: {
	 *         'Start Time': new Ext.grid.GridEditor(new Ext.form.TimeField({selectOnFocus:true}))
	 *     },
	 *     source: {
	 *         'Start Time': '10:00 AM'
	 *     }
	 * });
	 * &lt;/code&gt;
	 * {
	 * &quot;(name)&quot;: &quot;My Object&quot;,
	 * 	&quot;Created&quot;: new Date(Date.parse('10/15/2006')),  // date type
	 * 	&quot;Available&quot;: false,  // boolean type
	 * 	&quot;Version&quot;: .01,      // decimal type
	 * 	&quot;Description&quot;: &quot;A test object&quot;
	 * }
	 * &lt;/code&gt;