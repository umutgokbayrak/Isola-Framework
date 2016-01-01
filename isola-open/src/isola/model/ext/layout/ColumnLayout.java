package isola.model.ext.layout;
 * // All columns are percentages -- they must add up to 1
 * var p = new Ext.Panel({
 *     title: 'Column Layout - Percentage Only',
 *     layout:'column',
 *     items: [{
 *         title: 'Column 1',
 *         columnWidth: .25 
 *     },{
 *         title: 'Column 2',
 *         columnWidth: .6
 *     },{
 *         title: 'Column 3',
 *         columnWidth: .15
 *     }]
 * });
 * 
 * // Mix of width and columnWidth -- all columnWidth values values must add
 * // up to 1. The first column will take up exactly 120px, and the last two
 * // columns will fill the remaining container width.
 * var p = new Ext.Panel({
 *     title: 'Column Layout - Mixed',
 *     layout:'column',
 *     items: [{
 *         title: 'Column 1',
 *         width: 120
 *     },{
 *         title: 'Column 2',
 *         columnWidth: .8
 *     },{
 *         title: 'Column 3',
 *         columnWidth: .2
 *     }]
 * });
 * &lt;/code&gt;
	 * 
	 */