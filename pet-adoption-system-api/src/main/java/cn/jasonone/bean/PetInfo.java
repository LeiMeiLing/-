package cn.jasonone.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import lombok.Data;

/**
 * 宠物信息表
 * @TableName pet_info
 */
@Data
public class PetInfo implements Serializable {
    /**
     * 宠物编号
     */
    private Integer petId;

    /**
     * 宠物名
     */
    private String petName;

    /**
     * 种类
     */
    private String variety;

    /**
     * 性别
     */
    private String petSex;

    /**
     * 领养状态
     */
    private String petStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 图片
     */
    private byte[] petPicture;

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
        PetInfo other = (PetInfo) that;
        return (this.getPetId() == null ? other.getPetId() == null : this.getPetId().equals(other.getPetId()))
            && (this.getPetName() == null ? other.getPetName() == null : this.getPetName().equals(other.getPetName()))
            && (this.getVariety() == null ? other.getVariety() == null : this.getVariety().equals(other.getVariety()))
            && (this.getPetSex() == null ? other.getPetSex() == null : this.getPetSex().equals(other.getPetSex()))
            && (this.getPetStatus() == null ? other.getPetStatus() == null : this.getPetStatus().equals(other.getPetStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (Arrays.equals(this.getPetPicture(), other.getPetPicture()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPetId() == null) ? 0 : getPetId().hashCode());
        result = prime * result + ((getPetName() == null) ? 0 : getPetName().hashCode());
        result = prime * result + ((getVariety() == null) ? 0 : getVariety().hashCode());
        result = prime * result + ((getPetSex() == null) ? 0 : getPetSex().hashCode());
        result = prime * result + ((getPetStatus() == null) ? 0 : getPetStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + (Arrays.hashCode(getPetPicture()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", petId=").append(petId);
        sb.append(", petName=").append(petName);
        sb.append(", variety=").append(variety);
        sb.append(", petSex=").append(petSex);
        sb.append(", petStatus=").append(petStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", petPicture=").append(petPicture);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}