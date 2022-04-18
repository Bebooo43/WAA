import {useState, useEffect, useContext} from "react";
import Post from "../../components/Post/Post";
import axios from "axios";
import {PostContext} from "../../pages/dashboard/Dashboard";
import {Link} from "react-router-dom";
import {Selected} from "../../store/Selected";
import PostDetails from "../../components/PostDetails/PostDetails";

const Posts = (props) => {
    console.log("Post UPDATE");
    const setSelected = useContext(Selected);


    const [posts, setPosts] = useState([{id: 1, title: "iphone 13", content: "iphone 13", author: 1100},])
    const fetchProducts = () => {
        axios.get('http://localhost:8080/api/posts')
            .then(response => {
                setPosts(response.data);
            })
            .catch(error => {
                console.log(error.message)
            })
    }

    // fetchProducts();    TRY THIS 
    useEffect(() => {
        fetchProducts()
    }, [props.fetchFlag]) //ADD THIS LATER - props.fetchFlag


    const postsList = posts.map(product => {
        console.log("sada",product.id)
        return (<Link to={`${product.id}`} key={product.id}>
                <Post
                    title={product.title}
                    author={product.author}
                    content={product.content}
                    id={product.id}
                    key={product.id}
                />
            </Link>);
    });

    return <div className="Product">
        {postsList}
        <PostDetails/>
    </div>
}
export default Posts;