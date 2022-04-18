

const Post = (props) => {

    return (
        <div className="Content" onClick={props.setSelected}>
            <h1>{props.title}</h1>
            <div className="Field">
                {props.author}
            </div>
             <div className="Field">
                {props.content}
            </div>
        </div>
    );

}

export default Post;