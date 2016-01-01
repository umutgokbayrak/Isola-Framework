package isola.tags.ext.data;
 * &lt;ext:gridPanel id=&quot;myGrid&quot; width=&quot;400&quot; height=&quot;200&quot; forceFit=&quot;true&quot; renderTo=&quot;pbar&quot; border=&quot;true&quot;&gt;
 * 	&lt;ext:jsonStore url=&quot;jsonServlet.html&quot; root=&quot;result&quot;&gt;
 * 		&lt;ext:httpParam name=&quot;id&quot; value=&quot;111&quot;/&gt;
 * 		&lt;ext:httpParam name=&quot;user&quot; value=&quot;dummy&quot;/&gt;
 * 		&lt;ext:storeMapping name=&quot;name&quot; /&gt;
 * 		&lt;ext:storeMapping name=&quot;value&quot;/&gt;
 * 	&lt;/ext:jsonStore&gt;
 * 	&lt;ext:columnModel&gt;
 * 		 &lt;ext:gridColumn dataIndex=&quot;name&quot; header=&quot;Name&quot; /&gt;
 * 		 &lt;ext:gridColumn dataIndex=&quot;value&quot; header=&quot;Value&quot; /&gt;
 * 	&lt;/ext:columnModel&gt;
 * &lt;/ext:gridPanel&gt;
 * &lt;/code&gt;&lt;/pre&gt;
 * 
 * &lt;p&gt;This will consume a JSON string like: &lt;/p&gt;
 * &lt;pre&gt;&lt;code&gt;
 * 
 * {&quot;result&quot;:[
 * {&quot;name&quot;:&quot;java.runtime.name&quot;,&quot;value&quot;:&quot;Java(TM) SE Runtime Environment&quot;},
 * {&quot;name&quot;:&quot;com.atomikos.icatch.file&quot;,&quot;value&quot;:&quot;D:\\dev\\java\\jetty-6.1.7/contexts/test-jndi.d/WEB-INF/classes/jta.properties&quot;},
 * {&quot;name&quot;:&quot;sun.boot.library.path&quot;,&quot;value&quot;:&quot;D:\\dev\\java\\jdk1.6.0_03\\jre\\bin&quot;}
 * ]}
 * &lt;/code&gt;