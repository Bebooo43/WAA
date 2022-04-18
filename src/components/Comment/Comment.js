import React from 'react';
import {useContext} from "react";
import {ThemeColorContext} from "../../store/ThemeColor";
const Comment = (props) => {
    const colorContext = useContext(ThemeColorContext);
    return (

        <div style={{color:colorContext.color}} className='Comment'>
            {props.name}
        </div>

    );
};

export default Comment;