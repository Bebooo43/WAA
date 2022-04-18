import axios from "axios";
import {useEffect, useState, Fragment, useContext} from "react";
import Comment from "../Comment/Comment";
import './PostDetails.css';
import Comments from "../../containers/Comments/Coments";
import {PostContext} from "../../pages/dashboard/Dashboard";
import { useNavigate,useParams } from 'react-router-dom';


const PostDetails = () => {
    const navigate = useNavigate();
    const params = useParams();

    console.log("POSTDETAILS UPDATE");

    const [postDetail, setPostDetail] =  useState([]);;


    useEffect(
        () => {
            axios.get('http://localhost:8080/api/posts/' + params.id + '/comments')
                .then(response => {
                    setPostDetail(response.data)
                    console.log("postDetail:", postDetail)
                    console.log("RESPONSE:", response.data)
                })
                .catch(err => console.log(err.message))
        },
        [params.id])


    const deleteButtonClicked = (id) => {
        axios.delete('http://localhost:8080/api/posts/' + id)
            .then(response => {
                navigate("/");
            })
            .catch(err => {
                console.error(err);
            })

    }


    const space = <Fragment>&nbsp;&nbsp;</Fragment>;

    let productDetailsDisplay = null;
    if (params.id) {
        productDetailsDisplay = (

            <div className="PostDetail">
                <h1>Post Detials</h1>
                <div>
                     <br/>
                    <div style={{textAlign: "left"}}>
                        {space} Reviews <br/>
                        <Comments comment={postDetail} key={params.id}/>


                     </div>


                </div>
                <button onClick={() => {
                    deleteButtonClicked(params.id)
                }}> Delete
                </button>
            </div>
        );
    }

    return productDetailsDisplay


}

export default PostDetails;