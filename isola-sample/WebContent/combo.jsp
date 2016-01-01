<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext"%>
<ext:init/>
<ext:body runOnLoad="true">
      var data = [[1, 2], [3, 4]];
      var myStore = <ext:arrayStore data="data" autoLoad="true">
            <ext:storeMapping name="hebelek1"/>
            <ext:storeMapping name="hebelek2"/>
      </ext:arrayStore>
      <ext:panel layout="form" renderTo="mainDivMyDiv">
            <ext:comboBox hiddenId="idH1" name="name1" hiddenName="nameH1" storeId="myStore" displayField="hebelek1" valueField="hebelek2" fieldLabel="Hebelek">
            </ext:comboBox>
      </ext:panel>
</ext:body>
<div id="mainDivMyDiv"></div>
</body>
</html>
 