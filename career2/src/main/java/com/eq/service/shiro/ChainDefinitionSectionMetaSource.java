package com.eq.service.shiro;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.eq.dao.system.entity.Resource;
import com.eq.dao.system.inte.IResource;

public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section>
{
	@Autowired
	private IResource iResource;
	private String filterChainDefinitions;  
	/** 
     * 默认premission字符串 
     */  
    public static final String PREMISSION_STRING="perms[\"{0}\"]"; 
	@Override
	public Section getObject() throws Exception
	{
		List<Resource> list = iResource.findAll();
		Ini ini = new Ini();  
        //加载默认的url  
        ini.load(filterChainDefinitions);  
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME); 
		for(Resource r:list) {
			if(StringUtils.isNotBlank(r.getValue())&&StringUtils.isNotBlank(r.getPermission())) {
				//section.put(r.getValue(),  MessageFormat.format(PREMISSION_STRING,r.getPermission()));  
				section.put(r.getValue(), r.getPermission());
			}
		}
		return section;
	}

	@Override
	public Class<?> getObjectType()
	{
		return this.getClass();
	}

	@Override
	public boolean isSingleton()
	{
		return false;
	}

	public void setFilterChainDefinitions(String filterChainDefinitions)
	{
		this.filterChainDefinitions = filterChainDefinitions;
	}

}
