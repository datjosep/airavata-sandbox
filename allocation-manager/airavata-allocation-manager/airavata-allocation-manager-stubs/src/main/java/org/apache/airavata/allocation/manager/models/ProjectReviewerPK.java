/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.allocation.manager.models;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)")
public class ProjectReviewerPK implements org.apache.thrift.TBase<ProjectReviewerPK, ProjectReviewerPK._Fields>, java.io.Serializable, Cloneable, Comparable<ProjectReviewerPK> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ProjectReviewerPK");

  private static final org.apache.thrift.protocol.TField PROJECT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("projectId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField REVIEWER_FIELD_DESC = new org.apache.thrift.protocol.TField("reviewer", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ProjectReviewerPKStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ProjectReviewerPKTupleSchemeFactory();

  public java.lang.String projectId; // optional
  public java.lang.String reviewer; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PROJECT_ID((short)1, "projectId"),
    REVIEWER((short)4, "reviewer");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PROJECT_ID
          return PROJECT_ID;
        case 4: // REVIEWER
          return REVIEWER;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.PROJECT_ID,_Fields.REVIEWER};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PROJECT_ID, new org.apache.thrift.meta_data.FieldMetaData("projectId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REVIEWER, new org.apache.thrift.meta_data.FieldMetaData("reviewer", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ProjectReviewerPK.class, metaDataMap);
  }

  public ProjectReviewerPK() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ProjectReviewerPK(ProjectReviewerPK other) {
    if (other.isSetProjectId()) {
      this.projectId = other.projectId;
    }
    if (other.isSetReviewer()) {
      this.reviewer = other.reviewer;
    }
  }

  public ProjectReviewerPK deepCopy() {
    return new ProjectReviewerPK(this);
  }

  @Override
  public void clear() {
    this.projectId = null;
    this.reviewer = null;
  }

  public java.lang.String getProjectId() {
    return this.projectId;
  }

  public ProjectReviewerPK setProjectId(java.lang.String projectId) {
    this.projectId = projectId;
    return this;
  }

  public void unsetProjectId() {
    this.projectId = null;
  }

  /** Returns true if field projectId is set (has been assigned a value) and false otherwise */
  public boolean isSetProjectId() {
    return this.projectId != null;
  }

  public void setProjectIdIsSet(boolean value) {
    if (!value) {
      this.projectId = null;
    }
  }

  public java.lang.String getReviewer() {
    return this.reviewer;
  }

  public ProjectReviewerPK setReviewer(java.lang.String reviewer) {
    this.reviewer = reviewer;
    return this;
  }

  public void unsetReviewer() {
    this.reviewer = null;
  }

  /** Returns true if field reviewer is set (has been assigned a value) and false otherwise */
  public boolean isSetReviewer() {
    return this.reviewer != null;
  }

  public void setReviewerIsSet(boolean value) {
    if (!value) {
      this.reviewer = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case PROJECT_ID:
      if (value == null) {
        unsetProjectId();
      } else {
        setProjectId((java.lang.String)value);
      }
      break;

    case REVIEWER:
      if (value == null) {
        unsetReviewer();
      } else {
        setReviewer((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PROJECT_ID:
      return getProjectId();

    case REVIEWER:
      return getReviewer();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case PROJECT_ID:
      return isSetProjectId();
    case REVIEWER:
      return isSetReviewer();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ProjectReviewerPK)
      return this.equals((ProjectReviewerPK)that);
    return false;
  }

  public boolean equals(ProjectReviewerPK that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_projectId = true && this.isSetProjectId();
    boolean that_present_projectId = true && that.isSetProjectId();
    if (this_present_projectId || that_present_projectId) {
      if (!(this_present_projectId && that_present_projectId))
        return false;
      if (!this.projectId.equals(that.projectId))
        return false;
    }

    boolean this_present_reviewer = true && this.isSetReviewer();
    boolean that_present_reviewer = true && that.isSetReviewer();
    if (this_present_reviewer || that_present_reviewer) {
      if (!(this_present_reviewer && that_present_reviewer))
        return false;
      if (!this.reviewer.equals(that.reviewer))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetProjectId()) ? 131071 : 524287);
    if (isSetProjectId())
      hashCode = hashCode * 8191 + projectId.hashCode();

    hashCode = hashCode * 8191 + ((isSetReviewer()) ? 131071 : 524287);
    if (isSetReviewer())
      hashCode = hashCode * 8191 + reviewer.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ProjectReviewerPK other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetProjectId()).compareTo(other.isSetProjectId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProjectId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.projectId, other.projectId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetReviewer()).compareTo(other.isSetReviewer());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReviewer()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reviewer, other.reviewer);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ProjectReviewerPK(");
    boolean first = true;

    if (isSetProjectId()) {
      sb.append("projectId:");
      if (this.projectId == null) {
        sb.append("null");
      } else {
        sb.append(this.projectId);
      }
      first = false;
    }
    if (isSetReviewer()) {
      if (!first) sb.append(", ");
      sb.append("reviewer:");
      if (this.reviewer == null) {
        sb.append("null");
      } else {
        sb.append(this.reviewer);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ProjectReviewerPKStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ProjectReviewerPKStandardScheme getScheme() {
      return new ProjectReviewerPKStandardScheme();
    }
  }

  private static class ProjectReviewerPKStandardScheme extends org.apache.thrift.scheme.StandardScheme<ProjectReviewerPK> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ProjectReviewerPK struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PROJECT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.projectId = iprot.readString();
              struct.setProjectIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // REVIEWER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reviewer = iprot.readString();
              struct.setReviewerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ProjectReviewerPK struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.projectId != null) {
        if (struct.isSetProjectId()) {
          oprot.writeFieldBegin(PROJECT_ID_FIELD_DESC);
          oprot.writeString(struct.projectId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.reviewer != null) {
        if (struct.isSetReviewer()) {
          oprot.writeFieldBegin(REVIEWER_FIELD_DESC);
          oprot.writeString(struct.reviewer);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ProjectReviewerPKTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ProjectReviewerPKTupleScheme getScheme() {
      return new ProjectReviewerPKTupleScheme();
    }
  }

  private static class ProjectReviewerPKTupleScheme extends org.apache.thrift.scheme.TupleScheme<ProjectReviewerPK> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ProjectReviewerPK struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetProjectId()) {
        optionals.set(0);
      }
      if (struct.isSetReviewer()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetProjectId()) {
        oprot.writeString(struct.projectId);
      }
      if (struct.isSetReviewer()) {
        oprot.writeString(struct.reviewer);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ProjectReviewerPK struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.projectId = iprot.readString();
        struct.setProjectIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.reviewer = iprot.readString();
        struct.setReviewerIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

