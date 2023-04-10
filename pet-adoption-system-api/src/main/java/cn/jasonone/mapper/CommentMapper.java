package cn.jasonone.mapper;

import cn.jasonone.bean.Comment;

/**
* @author Mrli
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2023-04-10 09:59:49
* @Entity cn.jasonone.bean.Comment
*/
public interface CommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

}
