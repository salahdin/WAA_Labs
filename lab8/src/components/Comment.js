import axios from "axios";
import React, {useEffect} from "react";


const Comment = React.memo(({postId}) =>{
    const [comments, setComments] = React.useState([]);
    useEffect(() => {
        axios.get(`http://localhost:8080/api/v1/posts/${postId}/comments`)
        .then((response) => {
            console.log(response.data);
            setComments(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
    }, [postId]);

    return (
        <div>
            {comments.map((comment) => (
                <div key={comment.id}>
                    <p>{comment.content}</p>
                </div>
            ))}
        </div>
    )
});

export default Comment;