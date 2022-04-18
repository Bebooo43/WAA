import React from 'react'
import Comment from "../../components/Comment/Comment"

const Comments = (props) => {
    console.log("sddda",props.comment)
    const comments = props.comment.map((comment) => {
        return <Comment key={comment.id} comment={comment}/>;
    });
    return comments;
};

export default Comments;
