import axios from "axios";
import {useRef} from "react";
import { useNavigate } from 'react-router-dom';

const NewPost = (props) => {
    const navigate = useNavigate();

const newPostForm = useRef();
const addButtonClick = ()=>{
    const form = newPostForm.current;
    const data = {
        title: form['title'].value,
        content: form['content'].value,
        author: form['author'].value
    }

    axios.post('http://localhost:8080/api/posts',data)
        .then(response=>{
            navigate('/Posts'); // If you didn't place / it will understand to append

        }).catch()
}

    return (
        <div className="NewPost">
            <form ref={newPostForm} onSubmit={addButtonClick}>
                <h1> Add Post</h1>

                <label>Title</label>
                <input type="text" label={'title'} name={'title'} />

                <label>content</label>
                <input type="text" label={'content'} name={'content'} />

                <label>Author</label>
                <input type="text" label={'author'} name={'author'} />
            </form>

            <button onClick={addButtonClick}> Add Post</button>

        </div>
    );

}

export default NewPost;