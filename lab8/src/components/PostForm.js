import React, {useRef} from "react";

const PostForm = ({onForSubmit}) => {
    const formRef = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(formRef.current);
        const title = formData.get('title');
        const content = formData.get('content');
        console.log(title, content);
        onForSubmit(title, content);
    }

    return (
        <div>
            <h1>Post Form</h1>
            <form ref={formRef} onSubmit={handleSubmit}>
                <input type="text" name="title" placeholder="Title" />
                <br />
                <br />
                <textarea name="content" placeholder="Content" />
                <br />
                <br />
                <button type="submit">Post</button>
            </form>
        </div>
    )
}

export default PostForm;