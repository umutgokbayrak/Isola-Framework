package isola.tags.ext.toolbar;
 * &lt;ext:body runOnLoad="true"&gt;
 * 	var jsonStore = &lt;ext:jsonStore id="jsonStore" url="servlet/JsonSampleServlet" root="result" totalProperty="total" remoteSort="true" autoLoad="true"&gt;
 * 		&lt;ext:httpParam name="id" value="1"/&gt;
 * 		&lt;ext:httpParam name="action" value="env"/&gt;
 * 		&lt;ext:storeMapping name="name" /&gt;
 * 		&lt;ext:storeMapping name="value"/&gt;
 * 	&lt;/ext:jsonStore&gt;
 * 
 * 	&lt;ext:gridPanel storeId="jsonStore" renderTo="hebelek" width="700" height="400" border="true" frame="true" forceFit="true" title="Bu Mudur?" rowNumbererEnabled="true" region="north"&gt;
 * 		&lt;ext:pagingToolbar position="bottom" pageSize="10" displayInfo="true" storeId="jsonStore" /&gt;
 * 		&lt;ext:columnModel&gt;
 * 			&lt;ext:gridColumn dataIndex="name" sortable="true" header="Name" /&gt;
 * 			&lt;ext:gridColumn dataIndex="value" sortable="false" header="Value" /&gt;
 * 		&lt;/ext:columnModel&gt;
 * 	&lt;/ext:gridPanel&gt;
 * &lt;/ext:body&gt;
 * &lt;div id="hebelek"&gt;&lt;/div&gt;
 * </code>
 * &lt;ul&gt;
 * 	&lt;li&gt;limit: How many records should the servlet return.&lt;/li&gt;
 *  &lt;li&gt;start: The record number should the servlet start processing &lt;/li&gt;
 * &lt;/ul&gt;
 * 		String sStart = request.getParameter(&quot;start&quot;);
 * 	String sLimit = request.getParameter(&quot;limit&quot;);
 * &lt;/code&gt;