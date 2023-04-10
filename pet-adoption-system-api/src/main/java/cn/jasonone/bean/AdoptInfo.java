package cn.jasonone.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 领养信息表
 * @TableName adopt_info
 */
@Data
public class AdoptInfo implements Serializable {
    /**
     * 领养编号
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 宠物名
     */
    private String petname;

    /**
     * 种类
     */
    private String variety;

    /**
     * 性别
     */
    private String petSex;

    /**
     * 状态
     */
    private String petStatus;

    /**
     * 申请时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdoptInfo other = (AdoptInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPetname() == null ? other.getPetname() == null : this.getPetname().equals(other.getPetname()))
            && (this.getVariety() == null ? other.getVariety() == null : this.getVariety().equals(other.getVariety()))
            && (this.getPetSex() == null ? other.getPetSex() == null : this.getPetSex().equals(other.getPetSex()))
            && (this.getPetStatus() == null ? other.getPetStatus() == null : this.getPetStatus().equals(other.getPetStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPetname() == null) ? 0 : getPetname().hashCode());
        result = prime * result + ((getVariety() == null) ? 0 : getVariety().hashCode());
        result = prime * result + ((getPetSex() == null) ? 0 : getPetSex().hashCode());
        result = prime * result + ((getPetStatus() == null) ? 0 : getPetStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", petname=").append(petname);
        sb.append(", variety=").append(variety);
        sb.append(", petSex=").append(petSex);
        sb.append(", petStatus=").append(petStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}