import React, {useState, useEffect, createContext} from "react";
import NewPost from "../../components/NewPost/NewPost";
import PostDetails from "../../components/PostDetails/PostDetails";
import Post from "../../components/Post/Post";
import Posts from "../../containers/Posts/Posts";
import {ThemeColorContext} from "../../store/ThemeColor";
import Pages from "./Pages";
import Header from "../../containers/headers/Header";
import '../../containers/headers/Header.css';


const Dashboard = () => {
    return (
        <React.Fragment>
            <div className="header">
                <Header/>
            </div>
            <div className="Product">
                <Pages />
            </div>
        </React.Fragment>
    );

}


export default Dashboard;