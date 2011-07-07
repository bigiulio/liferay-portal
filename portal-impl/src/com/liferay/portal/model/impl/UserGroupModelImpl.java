/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.model.UserGroupModel;
import com.liferay.portal.model.UserGroupSoap;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the UserGroup service. Represents a row in the &quot;UserGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.UserGroupModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupImpl
 * @see com.liferay.portal.model.UserGroup
 * @see com.liferay.portal.model.UserGroupModel
 * @generated
 */
@JSON(strict = true)
public class UserGroupModelImpl extends BaseModelImpl<UserGroup>
	implements UserGroupModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user group model instance should use the {@link com.liferay.portal.model.UserGroup} interface instead.
	 */
	public static final String TABLE_NAME = "UserGroup";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userGroupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "parentUserGroupId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "addedByLDAPImport", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table UserGroup (userGroupId LONG not null primary key,companyId LONG,parentUserGroupId LONG,name VARCHAR(75) null,description STRING null,addedByLDAPImport BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table UserGroup";
	public static final String ORDER_BY_JPQL = " ORDER BY userGroup.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY UserGroup.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.UserGroup"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.UserGroup"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserGroup toModel(UserGroupSoap soapModel) {
		UserGroup model = new UserGroupImpl();

		model.setUserGroupId(soapModel.getUserGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setParentUserGroupId(soapModel.getParentUserGroupId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setAddedByLDAPImport(soapModel.getAddedByLDAPImport());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserGroup> toModels(UserGroupSoap[] soapModels) {
		List<UserGroup> models = new ArrayList<UserGroup>(soapModels.length);

		for (UserGroupSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public Class<?> getModelClass() {
		return UserGroup.class;
	}

	public String getModelClassName() {
		return UserGroup.class.getName();
	}

	public static final String MAPPING_TABLE_GROUPS_USERGROUPS_NAME = com.liferay.portal.model.impl.GroupModelImpl.MAPPING_TABLE_GROUPS_USERGROUPS_NAME;
	public static final boolean FINDER_CACHE_ENABLED_GROUPS_USERGROUPS = com.liferay.portal.model.impl.GroupModelImpl.FINDER_CACHE_ENABLED_GROUPS_USERGROUPS;
	public static final String MAPPING_TABLE_USERGROUPS_TEAMS_NAME = "UserGroups_Teams";
	public static final Object[][] MAPPING_TABLE_USERGROUPS_TEAMS_COLUMNS = {
			{ "userGroupId", Types.BIGINT },
			{ "teamId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_USERGROUPS_TEAMS_SQL_CREATE = "create table UserGroups_Teams (userGroupId LONG not null,teamId LONG not null,primary key (userGroupId, teamId))";
	public static final boolean FINDER_CACHE_ENABLED_USERGROUPS_TEAMS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.UserGroups_Teams"), true);
	public static final String MAPPING_TABLE_USERS_USERGROUPS_NAME = com.liferay.portal.model.impl.UserModelImpl.MAPPING_TABLE_USERS_USERGROUPS_NAME;
	public static final boolean FINDER_CACHE_ENABLED_USERS_USERGROUPS = com.liferay.portal.model.impl.UserModelImpl.FINDER_CACHE_ENABLED_USERS_USERGROUPS;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.UserGroup"));

	public UserGroupModelImpl() {
	}

	public long getPrimaryKey() {
		return _userGroupId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserGroupId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userGroupId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@JSON
	public long getUserGroupId() {
		return _userGroupId;
	}

	public void setUserGroupId(long userGroupId) {
		_userGroupId = userGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getParentUserGroupId() {
		return _parentUserGroupId;
	}

	public void setParentUserGroupId(long parentUserGroupId) {
		_parentUserGroupId = parentUserGroupId;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public boolean getAddedByLDAPImport() {
		return _addedByLDAPImport;
	}

	public boolean isAddedByLDAPImport() {
		return _addedByLDAPImport;
	}

	public void setAddedByLDAPImport(boolean addedByLDAPImport) {
		_addedByLDAPImport = addedByLDAPImport;
	}

	@Override
	public UserGroup toEscapedModel() {
		if (isEscapedModel()) {
			return (UserGroup)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (UserGroup)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					UserGroup.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		UserGroupImpl userGroupImpl = new UserGroupImpl();

		userGroupImpl.setUserGroupId(getUserGroupId());
		userGroupImpl.setCompanyId(getCompanyId());
		userGroupImpl.setParentUserGroupId(getParentUserGroupId());
		userGroupImpl.setName(getName());
		userGroupImpl.setDescription(getDescription());
		userGroupImpl.setAddedByLDAPImport(getAddedByLDAPImport());

		userGroupImpl.resetOriginalValues();

		return userGroupImpl;
	}

	public int compareTo(UserGroup userGroup) {
		int value = 0;

		value = getName().compareTo(userGroup.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserGroup userGroup = null;

		try {
			userGroup = (UserGroup)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = userGroup.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		UserGroupModelImpl userGroupModelImpl = this;

		userGroupModelImpl._originalCompanyId = userGroupModelImpl._companyId;

		userGroupModelImpl._setOriginalCompanyId = false;

		userGroupModelImpl._originalName = userGroupModelImpl._name;
	}

	@Override
	public CacheModel<UserGroup> toCacheModel() {
		UserGroupCacheModel userGroupCacheModel = new UserGroupCacheModel();

		userGroupCacheModel.userGroupId = getUserGroupId();

		userGroupCacheModel.companyId = getCompanyId();

		userGroupCacheModel.parentUserGroupId = getParentUserGroupId();

		userGroupCacheModel.name = getName();

		String name = userGroupCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			userGroupCacheModel.name = null;
		}

		userGroupCacheModel.description = getDescription();

		String description = userGroupCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			userGroupCacheModel.description = null;
		}

		userGroupCacheModel.addedByLDAPImport = getAddedByLDAPImport();

		return userGroupCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{userGroupId=");
		sb.append(getUserGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", parentUserGroupId=");
		sb.append(getParentUserGroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", addedByLDAPImport=");
		sb.append(getAddedByLDAPImport());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.UserGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userGroupId</column-name><column-value><![CDATA[");
		sb.append(getUserGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentUserGroupId</column-name><column-value><![CDATA[");
		sb.append(getParentUserGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addedByLDAPImport</column-name><column-value><![CDATA[");
		sb.append(getAddedByLDAPImport());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UserGroup.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			UserGroup.class
		};
	private long _userGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _parentUserGroupId;
	private String _name;
	private String _originalName;
	private String _description;
	private boolean _addedByLDAPImport;
	private transient ExpandoBridge _expandoBridge;
	private UserGroup _escapedModelProxy;
}