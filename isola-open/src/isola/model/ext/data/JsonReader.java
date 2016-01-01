package isola.model.ext.data;
 * var Employee = Ext.data.Record.create([
 *    {name: 'name', mapping: 'name'},     // &quot;mapping&quot; property not needed if it's the same as &quot;name&quot;
 *   {name: 'occupation'}                 // This field will use &quot;occupation&quot; as the mapping.
 * ]);
 * 
 * var myReader = new Ext.data.JsonReader({
 *   totalProperty: &quot;results&quot;,    // The property which contains the total dataset size (optional)
 *   root: &quot;rows&quot;,                // The property which contains an Array of row objects
 *   id: &quot;id&quot;                     // The property within each row object that provides an ID for the record (optional)
 * }, Employee);
 * &lt;/code&gt;
 * { 'results': 2, 'rows': [
 *   { 'id': 1, 'name': 'Bill', occupation: 'Gardener' },
 *   { 'id': 2, 'name': 'Ben', occupation: 'Horticulturalist' } ]
 * }
 * &lt;/code&gt;
 * var myReader = new Ext.data.JsonReader();
 * &lt;/code&gt;
 * {
 * 'metaData': {
 *   totalProperty: 'results',
 *   root: 'rows',
 *   id: 'id',
 *   fields: [
 *     {name: 'name'},
 *     {name: 'occupation'} ]
 *  },
 * 'results': 2, 'rows': [
 *   { 'id': 1, 'name': 'Bill', occupation: 'Gardener' },
 *   { 'id': 2, 'name': 'Ben', occupation: 'Horticulturalist' } ]
 * }
 * &lt;/code&gt;