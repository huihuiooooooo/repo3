package cn.itcast.domain;

import javax.persistence.*;

/**
 * 客户的实体类
 *      配置映射关系
 *          1.实体类和表的映射关系
 *          2.实体类中属性和表中字段的映射关系
 * @Entity :声明实体类
 * @Table :配置实体类和表的映射关系
 */
@Entity
@Table(name = "cst_customer")
public class Customer {

    //声明主键的配置
    @Id
    //配置主键生成方式(IDENTITY 自增mysql SEQUENCE 序列orcle)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    public Integer custId; //客户主键

    @Column(name = "cust_name")
    public String custName;//客户名称

    @Column(name = "cust_source")
    public String custSource;//客户来源

    @Column(name = "cust_level")
    public String custLevel;//客户级别

    @Column(name = "cust_industry")
    public String custIndustry;//客户所属行业

    @Column(name = "cust_phone")
    public String custPhone;//客户的联系方式

    @Column(name = "cust_address")
    public String custAddress;//客户地址

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
}
