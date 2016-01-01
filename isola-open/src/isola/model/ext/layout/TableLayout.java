package isola.model.ext.layout;
 * 
 * // This code will generate a layout table that is 3 columns by 2 rows
 * // with some spanning included.  The basic layout will be:
 * // +--------+-----------------+
 * // |   A    |   B             |
 * // |        |--------+--------|
 * // |        |   C    |   D    |
 * // +--------+--------+--------+
 * var table = new Ext.Panel({
 *     title: 'Table Layout',
 *     layout:'table',
 *     defaults: {
 *         // applied to each contained panel
 *         bodyStyle:'padding:20px'
 *     },
 *     layoutConfig: {
 *         // The total column count must be specified here
 *         columns: 3
 *     },
 *     items: [{
 *         html: '&lt;p&gt;Cell A content&lt;/p&gt;',
 *         rowspan: 2
 *     },{
 *         html: '&lt;p&gt;Cell B content&lt;/p&gt;',
 *         colspan: 2
 *     },{
 *         html: '&lt;p&gt;Cell C content&lt;/p&gt;'
 *     },{
 *         html: '&lt;p&gt;Cell D content&lt;/p&gt;'
 *     }]
 * });
 * &lt;/code&gt;