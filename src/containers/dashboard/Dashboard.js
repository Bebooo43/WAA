import React, {useState, useEffect, createContext} from "react";
import NewPost from "../../components/NewPost/NewPost";
import PostDetails from "../../components/PostDetails/PostDetails";
import Post from "../../components/Post/Post";
import Posts from "../../containers/Posts/Posts";
import {ThemeColorContext} from "../../store/ThemeColor";

export const PostContext = createContext(null);

const Dashboard = () => {

    const [themeColorState, setThemeColorState] = useState({color: "red"});
    const [fetchFlag, setFetchflag] = useState(true);
    const [selectedState, setSelectedState] = useState(0);

    const changeFetchFlag = () => {
        setFetchflag(!fetchFlag);
    }

  const setSelected = (id) => {
        setSelectedState(id);
    }

    const reviewColorHandler = () => {
        if (themeColorState.color === "red") {
            setThemeColorState({color: "blue"});
        } else {
            setThemeColorState({color: "red"});
        }
    }


    return (
        <PostContext.Provider value={{ selectedState, setSelectedState }}>

        <div>

            <div>

                     <Posts
                         fetchFlag={fetchFlag}
                    />
            </div>
            <button onClick={reviewColorHandler}>Change color</button>
            {<div>
                <PostDetails
                     changeFetchFlag={changeFetchFlag}/>

            </div>}
            <div>
                <NewPost changeFetchFlag={changeFetchFlag}/>

            </div>


        </div>
        </PostContext.Provider>

    );

}


export default Dashboard;