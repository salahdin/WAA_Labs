import React, {useContext} from 'react';
import { SelectContext } from '../containers/Dashboard';
import Comment from "./Comment";

const PostDetail = () => {
    const post = useContext(SelectContext)
    return (
        <div>
            <h1>{post.title}</h1>
            <p>{post.content}</p>
            <Comment postId={post.id} />
        </div>
    );
};

export default PostDetail;

