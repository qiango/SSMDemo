package com.wangq.ssm.jwt.requestFilter;

import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssRequestWrapper extends HttpServletRequestWrapper  {
	
	public XssRequestWrapper(HttpServletRequest request) {
		super(request);		
//		getParameterMap();
//		checkHeader();
	}

	public String[] getParameterValues(String parameter) {
		String[] results = super.getParameterValues(parameter);
		if (results == null)
			return null;
		int count = results.length;
		String[] trimResults = new String[count];
		for (int i = 0; i < count; i++) {
			trimResults[i] = results[i].trim();
			trimResults[i] = ScriptReplace.ScriptReplaceStr(ScriptReplace.xssClean(trimResults[i]));
		}
		return trimResults;
	}

//	public String getParameter(String value){
//		return ScriptReplace.ScriptReplaceStr(ScriptReplace.xssClean(super.getParameter(value)));
//	}
	
	public String getRequestURI() {
		return ScriptReplace.ScriptReplaceStr(ScriptReplace.xssClean(super.getRequestURI()));
	}
	
	public String getQueryString() {
		
		String queryString = super.getQueryString();
		if(null!=queryString){
			return ScriptReplace.ScriptReplaceStr(ScriptReplace.xssClean(super.getQueryString()));
		}else{
			return super.getQueryString();
		}
		
	}
	
	public boolean checkHeader(){  
		Map<String, String[]> request_map = super.getParameterMap();
		Iterator iterator = request_map.entrySet().iterator();
		
			while (iterator.hasNext()) {
				Map.Entry me = (Map.Entry) iterator.next();
				String[] values = (String[]) me.getValue();
				for (int i = 0; i < values.length; i++) {
					if (values[i] != null) {
						String retStr = ScriptReplace.ScriptReplaceStr(ScriptReplace.xssClean(values[i]));
						if(values[i]!=null && !values[i].equals(retStr)){
							 return true;
						}
					}
				}
			}
        return false;  
    }
}






