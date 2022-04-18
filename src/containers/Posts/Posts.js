import {useState, useEffect, useContext} from "react";
import Post from "../../components/Post/Post";
import axios from "axios";
import {PostContext} from "../dashboard/Dashboard";


const Posts = (props) => {
    console.log("Post UPDATE");
    const { selectedState, setSelectedState } = useContext(PostContext);

    const [posts, setPosts] = useState(
        [
            { id: 1, title: "iphone 13",content: "iphone 13", author: 1100 },
          ]
    )
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
        },
        [props.fetchFlag]) //ADD THIS LATER - props.fetchFlag


    const postsList = posts.map(product => {
        return <Post
            title={product.title}
            author={product.author}
            post={product}
            content={product.content}
            id={product.id}
            key={product.id}
            setSelected={() => { setSelectedState(product.id) }}
        />
    });

    return postsList;
}

export default Posts;