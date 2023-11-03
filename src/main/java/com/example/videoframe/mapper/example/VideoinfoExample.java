package com.example.videoframe.mapper.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public VideoinfoExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public VideoinfoExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        VideoinfoExample example = new VideoinfoExample();
        return example.createCriteria();
    }

    public VideoinfoExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public VideoinfoExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriIsNull() {
            addCriterion("descri is null");
            return (Criteria) this;
        }

        public Criteria andDescriIsNotNull() {
            addCriterion("descri is not null");
            return (Criteria) this;
        }

        public Criteria andDescriEqualTo(String value) {
            addCriterion("descri =", value, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriNotEqualTo(String value) {
            addCriterion("descri <>", value, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriGreaterThan(String value) {
            addCriterion("descri >", value, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriGreaterThanOrEqualTo(String value) {
            addCriterion("descri >=", value, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriLessThan(String value) {
            addCriterion("descri <", value, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriLessThanOrEqualTo(String value) {
            addCriterion("descri <=", value, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriLike(String value) {
            addCriterion("descri like", value, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriNotLike(String value) {
            addCriterion("descri not like", value, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriIn(List<String> values) {
            addCriterion("descri in", values, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriNotIn(List<String> values) {
            addCriterion("descri not in", values, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriBetween(String value1, String value2) {
            addCriterion("descri between", value1, value2, "descri");
            return (Criteria) this;
        }

        public Criteria andDescriNotBetween(String value1, String value2) {
            addCriterion("descri not between", value1, value2, "descri");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidIsNull() {
            addCriterion("attachGroupId is null");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidIsNotNull() {
            addCriterion("attachGroupId is not null");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidEqualTo(String value) {
            addCriterion("attachGroupId =", value, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidNotEqualTo(String value) {
            addCriterion("attachGroupId <>", value, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidGreaterThan(String value) {
            addCriterion("attachGroupId >", value, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidGreaterThanOrEqualTo(String value) {
            addCriterion("attachGroupId >=", value, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidLessThan(String value) {
            addCriterion("attachGroupId <", value, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidLessThanOrEqualTo(String value) {
            addCriterion("attachGroupId <=", value, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidLike(String value) {
            addCriterion("attachGroupId like", value, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidNotLike(String value) {
            addCriterion("attachGroupId not like", value, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidIn(List<String> values) {
            addCriterion("attachGroupId in", values, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidNotIn(List<String> values) {
            addCriterion("attachGroupId not in", values, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidBetween(String value1, String value2) {
            addCriterion("attachGroupId between", value1, value2, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andAttachgroupidNotBetween(String value1, String value2) {
            addCriterion("attachGroupId not between", value1, value2, "attachgroupid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidIsNull() {
            addCriterion("userInfoId is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoidIsNotNull() {
            addCriterion("userInfoId is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoidEqualTo(Integer value) {
            addCriterion("userInfoId =", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidNotEqualTo(Integer value) {
            addCriterion("userInfoId <>", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidGreaterThan(Integer value) {
            addCriterion("userInfoId >", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userInfoId >=", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidLessThan(Integer value) {
            addCriterion("userInfoId <", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidLessThanOrEqualTo(Integer value) {
            addCriterion("userInfoId <=", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidIn(List<Integer> values) {
            addCriterion("userInfoId in", values, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidNotIn(List<Integer> values) {
            addCriterion("userInfoId not in", values, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidBetween(Integer value1, Integer value2) {
            addCriterion("userInfoId between", value1, value2, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("userInfoId not between", value1, value2, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1IsNull() {
            addCriterion("attgroupid1 is null");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1IsNotNull() {
            addCriterion("attgroupid1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1EqualTo(String value) {
            addCriterion("attgroupid1 =", value, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1NotEqualTo(String value) {
            addCriterion("attgroupid1 <>", value, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1GreaterThan(String value) {
            addCriterion("attgroupid1 >", value, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1GreaterThanOrEqualTo(String value) {
            addCriterion("attgroupid1 >=", value, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1LessThan(String value) {
            addCriterion("attgroupid1 <", value, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1LessThanOrEqualTo(String value) {
            addCriterion("attgroupid1 <=", value, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1Like(String value) {
            addCriterion("attgroupid1 like", value, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1NotLike(String value) {
            addCriterion("attgroupid1 not like", value, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1In(List<String> values) {
            addCriterion("attgroupid1 in", values, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1NotIn(List<String> values) {
            addCriterion("attgroupid1 not in", values, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1Between(String value1, String value2) {
            addCriterion("attgroupid1 between", value1, value2, "attgroupid1");
            return (Criteria) this;
        }

        public Criteria andAttgroupid1NotBetween(String value1, String value2) {
            addCriterion("attgroupid1 not between", value1, value2, "attgroupid1");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private VideoinfoExample example;

        protected Criteria(VideoinfoExample example) {
            super();
            this.example = example;
        }

        public VideoinfoExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(VideoinfoExample example);
    }
}