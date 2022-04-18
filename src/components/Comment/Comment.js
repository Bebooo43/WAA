import React from 'react';
import {useContext} from "react";
import {ThemeColorContext} from "../../store/ThemeColor";

const Comment = (props) => {
    const colorContext = useContext(ThemeColorContext);

    return (

        <div  className='Comment'>
            {props}
        </div>

    );

}

export default Comment;