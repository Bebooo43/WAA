 import NewPost from "../../components/NewPost/NewPost";
import Posts from "../../containers/Posts/Posts";
import PostDetails from "../../components/PostDetails/PostDetails";
 import {
     Navigate,
     Routes,
     Route,
 } from "react-router-dom";


const PageRoutes = () => (

    <Routes>
        <Route path="/" element={<Navigate replace to="/posts"/>}/>
        <Route path="posts" element={<Posts/>}>
            <Route path=":id" element={<PostDetails/>}/>
        </Route>

        <Route path="newPost" element={<NewPost/>}/>
    </Routes>
)

export default PageRoutes;
