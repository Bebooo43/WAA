import axios from "axios";
import {useEffect, useState, Fragment, useContext} from "react";
import Comment from "../Comment/Comment";
import './PostDetails.css';
import Comments from "../../containers/Comments/Coments";
import {PostContext} from "../../containers/dashboard/Dashboard";


const PostDetails = (props) => {
    const { selectedState, setSelectedState } = useContext(PostContext);


    console.log("POSTDETAILS UPDATE");

    const [postDetail, setPostDetail] = useState([{
        id: 0,
        name: ""
    }]);


    useEffect(
        () => {
            axios.get('http://localhost:8080/api/posts/' + selectedState + '/comments')
                .then(response => {
                    setPostDetail(response.data)
                    console.log("postDetail:", postDetail)
                    console.log("RESPONSE:", response.data)
                })
                .catch(err => console.log(err.message))
        },
        [selectedState])


    const deleteButtonClicked = (id) => {
        axios.delete('http://localhost:8080/api/posts/' + selectedState)
            .then(response => {
                props.changeFetchFlag();
            })
            .catch(err => {
                console.error(err);
            })

    }


    const space = <Fragment>&nbsp;&nbsp;</Fragment>;

    let productDetailsDisplay = null;
    if (selectedState!== 0) {
        productDetailsDisplay = (

            <div className="PostDetail">
                <div>
                    Post Details
                </div>
                <h1>Post Detials</h1>
                <div>
                    {postDetail.id}
                    <br/>
                    <div style={{textAlign: "left"}}>
                        {space} Reviews <br/>
                        <Comments comment={postDetail} key={selectedState}/>
                    </div>


                </div>
                <button onClick={() => {
                    deleteButtonClicked(selectedState)
                }}> Delete
                </button>
            </div>
        );
    }

    return productDetailsDisplay


}

export default PostDetails;