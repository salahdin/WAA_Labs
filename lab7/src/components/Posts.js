import React from "react";
import Post from "./Post";


const Posts = ({posts, onPostClick}) => {
    return (
        <div>
        {posts.map((post) => (
            <Post key={post.id} id={post.id} title={post.title} onClick={()=>onPostClick(post)} />
        ))}
    </div>
    );
};

export default Posts;
