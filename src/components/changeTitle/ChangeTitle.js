
const ChangeTitle = (props) => {



    return (
        <div className="Content">
         
                <h1>Change Title</h1>

                <label>Titel</label>
                <input type="text"
                    name={'name'}
                    onChange={props.onChange}
                    value={props.title}
                />



                <button onClick={props.addButtonClicked}>change </button>
        </div>
    );

}

export default ChangeTitle;