package isola.model.ext.data;
 *  var Employee = Ext.data.Record.create([
 *  {name: 'name', mapping: 'name'},     // &quot;mapping&quot; property not needed if it's the same as &quot;name&quot;
 *  {name: 'occupation'}                 // This field will use &quot;occupation&quot; as the mapping.
 * ]);
 * 
 * var myReader = new Ext.data.XmlReader({
 *  totalRecords: &quot;results&quot;, // The element which contains the total dataset size (optional)
 *  record: &quot;row&quot;,           // The repeated element which contains row information
 *  id: &quot;id&quot;                 // The element within the row that provides an ID for the record (optional)
 * }, Employee);
 * &lt;/code&gt;