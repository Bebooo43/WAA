import React, {useEffect, useState} from 'react';
import axios from "axios";
import './PostDetails.css'
import {Fragment} from "react";
import Comment from "../Comment/Comment";
import Comments from "../../containers/Comments/Coments";
const PostDetails = ({ id, setSelected, changeFetchFlag }) => {
    const [postDetail, setPostDetail] = useState({})

    useEffect(() => {
        axios.get('http://localhost:8080/api/posts/' + id+ '/comments')
            .then(response => {
                console.log(response.data)
                setPostDetail(response.data)
            }).catch(err => console.log(err.message))
    },[id]);

    const deleteButtonClicked = (id) => {
      axios.delete('http://localhost:8080/api/posts/' +id)
          .then(response=>{
              console.log("Deleted successfully");
              changeFetchFlag();
              setSelected(0);
          }).catch(err=> console.log(err.message))
    }

    const space = <Fragment>&nbsp;&nbsp;</Fragment>;
    let postDetailDisplay = null;
    console.log(id)
    if(id!==0){
         postDetailDisplay = (
         <div className="PostDetail">
             <div>
                 {postDetail.title}
             </div>
             <h1> {postDetail.title}</h1>
             <div >
                 {postDetail.content}
                 <br />
                 <div style={{ textAlign: "left" }}>
                      {space} Comments <br />
                     {postDetail.comments != null ? (
                         <Comments comments={postDetail.comments} />
                     ) : null}
                 </div>

             </div>
             <button onClick={ () => {deleteButtonClicked(id)}}> Delete</button>
         </div>
     )
    }
return postDetailDisplay

}

export default PostDetails;