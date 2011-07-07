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

package com.liferay.portlet.documentlibrary.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFileVersionModel;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the DLFileVersion service. Represents a row in the &quot;DLFileVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.documentlibrary.model.DLFileVersionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DLFileVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileVersionImpl
 * @see com.liferay.portlet.documentlibrary.model.DLFileVersion
 * @see com.liferay.portlet.documentlibrary.model.DLFileVersionModel
 * @generated
 */
public class DLFileVersionModelImpl extends BaseModelImpl<DLFileVersion>
	implements DLFileVersionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document library file version model instance should use the {@link com.liferay.portlet.documentlibrary.model.DLFileVersion} interface instead.
	 */
	public static final String TABLE_NAME = "DLFileVersion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "fileVersionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "repositoryId", Types.BIGINT },
			{ "fileEntryId", Types.BIGINT },
			{ "extension", Types.VARCHAR },
			{ "mimeType", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "changeLog", Types.VARCHAR },
			{ "extraSettings", Types.CLOB },
			{ "fileEntryTypeId", Types.BIGINT },
			{ "version", Types.VARCHAR },
			{ "size_", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table DLFileVersion (fileVersionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,repositoryId LONG,fileEntryId LONG,extension VARCHAR(75) null,mimeType VARCHAR(75) null,title VARCHAR(255) null,description STRING null,changeLog VARCHAR(75) null,extraSettings TEXT null,fileEntryTypeId LONG,version VARCHAR(75) null,size_ LONG,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table DLFileVersion";
	public static final String ORDER_BY_JPQL = " ORDER BY dlFileVersion.fileEntryId DESC, dlFileVersion.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY DLFileVersion.fileEntryId DESC, DLFileVersion.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.documentlibrary.model.DLFileVersion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.documentlibrary.model.DLFileVersion"),
			true);

	public Class<?> getModelClass() {
		return DLFileVersion.class;
	}

	public String getModelClassName() {
		return DLFileVersion.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.documentlibrary.model.DLFileVersion"));

	public DLFileVersionModelImpl() {
	}

	public long getPrimaryKey() {
		return _fileVersionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFileVersionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_fileVersionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getFileVersionId() {
		return _fileVersionId;
	}

	public void setFileVersionId(long fileVersionId) {
		_fileVersionId = fileVersionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getRepositoryId() {
		return _repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		_repositoryId = repositoryId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		if (!_setOriginalFileEntryId) {
			_setOriginalFileEntryId = true;

			_originalFileEntryId = _fileEntryId;
		}

		_fileEntryId = fileEntryId;
	}

	public long getOriginalFileEntryId() {
		return _originalFileEntryId;
	}

	public String getExtension() {
		if (_extension == null) {
			return StringPool.BLANK;
		}
		else {
			return _extension;
		}
	}

	public void setExtension(String extension) {
		_extension = extension;
	}

	public String getMimeType() {
		if (_mimeType == null) {
			return StringPool.BLANK;
		}
		else {
			return _mimeType;
		}
	}

	public void setMimeType(String mimeType) {
		_mimeType = mimeType;
	}

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
	}

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

	public String getChangeLog() {
		if (_changeLog == null) {
			return StringPool.BLANK;
		}
		else {
			return _changeLog;
		}
	}

	public void setChangeLog(String changeLog) {
		_changeLog = changeLog;
	}

	public String getExtraSettings() {
		if (_extraSettings == null) {
			return StringPool.BLANK;
		}
		else {
			return _extraSettings;
		}
	}

	public void setExtraSettings(String extraSettings) {
		_extraSettings = extraSettings;
	}

	public long getFileEntryTypeId() {
		return _fileEntryTypeId;
	}

	public void setFileEntryTypeId(long fileEntryTypeId) {
		_fileEntryTypeId = fileEntryTypeId;
	}

	public String getVersion() {
		if (_version == null) {
			return StringPool.BLANK;
		}
		else {
			return _version;
		}
	}

	public void setVersion(String version) {
		if (_originalVersion == null) {
			_originalVersion = _version;
		}

		_version = version;
	}

	public String getOriginalVersion() {
		return GetterUtil.getString(_originalVersion);
	}

	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	/**
	 * @deprecated {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public DLFileVersion toEscapedModel() {
		if (isEscapedModel()) {
			return (DLFileVersion)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (DLFileVersion)Proxy.newProxyInstance(_classLoader,
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
					DLFileVersion.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DLFileVersionImpl dlFileVersionImpl = new DLFileVersionImpl();

		dlFileVersionImpl.setFileVersionId(getFileVersionId());
		dlFileVersionImpl.setGroupId(getGroupId());
		dlFileVersionImpl.setCompanyId(getCompanyId());
		dlFileVersionImpl.setUserId(getUserId());
		dlFileVersionImpl.setUserName(getUserName());
		dlFileVersionImpl.setCreateDate(getCreateDate());
		dlFileVersionImpl.setRepositoryId(getRepositoryId());
		dlFileVersionImpl.setFileEntryId(getFileEntryId());
		dlFileVersionImpl.setExtension(getExtension());
		dlFileVersionImpl.setMimeType(getMimeType());
		dlFileVersionImpl.setTitle(getTitle());
		dlFileVersionImpl.setDescription(getDescription());
		dlFileVersionImpl.setChangeLog(getChangeLog());
		dlFileVersionImpl.setExtraSettings(getExtraSettings());
		dlFileVersionImpl.setFileEntryTypeId(getFileEntryTypeId());
		dlFileVersionImpl.setVersion(getVersion());
		dlFileVersionImpl.setSize(getSize());
		dlFileVersionImpl.setStatus(getStatus());
		dlFileVersionImpl.setStatusByUserId(getStatusByUserId());
		dlFileVersionImpl.setStatusByUserName(getStatusByUserName());
		dlFileVersionImpl.setStatusDate(getStatusDate());

		dlFileVersionImpl.resetOriginalValues();

		return dlFileVersionImpl;
	}

	public int compareTo(DLFileVersion dlFileVersion) {
		int value = 0;

		if (getFileEntryId() < dlFileVersion.getFileEntryId()) {
			value = -1;
		}
		else if (getFileEntryId() > dlFileVersion.getFileEntryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(),
				dlFileVersion.getCreateDate());

		value = value * -1;

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

		DLFileVersion dlFileVersion = null;

		try {
			dlFileVersion = (DLFileVersion)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dlFileVersion.getPrimaryKey();

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
		DLFileVersionModelImpl dlFileVersionModelImpl = this;

		dlFileVersionModelImpl._originalFileEntryId = dlFileVersionModelImpl._fileEntryId;

		dlFileVersionModelImpl._setOriginalFileEntryId = false;

		dlFileVersionModelImpl._originalVersion = dlFileVersionModelImpl._version;
	}

	@Override
	public CacheModel<DLFileVersion> toCacheModel() {
		DLFileVersionCacheModel dlFileVersionCacheModel = new DLFileVersionCacheModel();

		dlFileVersionCacheModel.fileVersionId = getFileVersionId();

		dlFileVersionCacheModel.groupId = getGroupId();

		dlFileVersionCacheModel.companyId = getCompanyId();

		dlFileVersionCacheModel.userId = getUserId();

		dlFileVersionCacheModel.userName = getUserName();

		String userName = dlFileVersionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dlFileVersionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dlFileVersionCacheModel.createDate = createDate.getTime();
		}

		dlFileVersionCacheModel.repositoryId = getRepositoryId();

		dlFileVersionCacheModel.fileEntryId = getFileEntryId();

		dlFileVersionCacheModel.extension = getExtension();

		String extension = dlFileVersionCacheModel.extension;

		if ((extension != null) && (extension.length() == 0)) {
			dlFileVersionCacheModel.extension = null;
		}

		dlFileVersionCacheModel.mimeType = getMimeType();

		String mimeType = dlFileVersionCacheModel.mimeType;

		if ((mimeType != null) && (mimeType.length() == 0)) {
			dlFileVersionCacheModel.mimeType = null;
		}

		dlFileVersionCacheModel.title = getTitle();

		String title = dlFileVersionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			dlFileVersionCacheModel.title = null;
		}

		dlFileVersionCacheModel.description = getDescription();

		String description = dlFileVersionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			dlFileVersionCacheModel.description = null;
		}

		dlFileVersionCacheModel.changeLog = getChangeLog();

		String changeLog = dlFileVersionCacheModel.changeLog;

		if ((changeLog != null) && (changeLog.length() == 0)) {
			dlFileVersionCacheModel.changeLog = null;
		}

		dlFileVersionCacheModel.extraSettings = getExtraSettings();

		String extraSettings = dlFileVersionCacheModel.extraSettings;

		if ((extraSettings != null) && (extraSettings.length() == 0)) {
			dlFileVersionCacheModel.extraSettings = null;
		}

		dlFileVersionCacheModel.fileEntryTypeId = getFileEntryTypeId();

		dlFileVersionCacheModel.version = getVersion();

		String version = dlFileVersionCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			dlFileVersionCacheModel.version = null;
		}

		dlFileVersionCacheModel.size = getSize();

		dlFileVersionCacheModel.status = getStatus();

		dlFileVersionCacheModel.statusByUserId = getStatusByUserId();

		dlFileVersionCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = dlFileVersionCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			dlFileVersionCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			dlFileVersionCacheModel.statusDate = statusDate.getTime();
		}

		return dlFileVersionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{fileVersionId=");
		sb.append(getFileVersionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", repositoryId=");
		sb.append(getRepositoryId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", extension=");
		sb.append(getExtension());
		sb.append(", mimeType=");
		sb.append(getMimeType());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", changeLog=");
		sb.append(getChangeLog());
		sb.append(", extraSettings=");
		sb.append(getExtraSettings());
		sb.append(", fileEntryTypeId=");
		sb.append(getFileEntryTypeId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", size=");
		sb.append(getSize());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.documentlibrary.model.DLFileVersion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fileVersionId</column-name><column-value><![CDATA[");
		sb.append(getFileVersionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repositoryId</column-name><column-value><![CDATA[");
		sb.append(getRepositoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extension</column-name><column-value><![CDATA[");
		sb.append(getExtension());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mimeType</column-name><column-value><![CDATA[");
		sb.append(getMimeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>changeLog</column-name><column-value><![CDATA[");
		sb.append(getChangeLog());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extraSettings</column-name><column-value><![CDATA[");
		sb.append(getExtraSettings());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryTypeId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DLFileVersion.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DLFileVersion.class
		};
	private long _fileVersionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private long _repositoryId;
	private long _fileEntryId;
	private long _originalFileEntryId;
	private boolean _setOriginalFileEntryId;
	private String _extension;
	private String _mimeType;
	private String _title;
	private String _description;
	private String _changeLog;
	private String _extraSettings;
	private long _fileEntryTypeId;
	private String _version;
	private String _originalVersion;
	private long _size;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private transient ExpandoBridge _expandoBridge;
	private DLFileVersion _escapedModelProxy;
}