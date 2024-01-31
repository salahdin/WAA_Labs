import React, { useState } from 'react';
import Posts from '../components/Posts';
import PostDetail from '../components/PostDetail'

const Dashboard = () => {
    const [posts, setPosts] = useState([
        { id: 1, title: "Post 1", content: "This is the content of Post 1" },
        { id: 2, title: "Post 2", content: "This is the content of Post 2" },
        { id: 3, title: "Post 3", content: "This is the content of Post 3" },
    ]);

    const [newTitle, setNewTitle] = useState('');
    const [selectPost, setSelectPost] = useState(posts[0])

    const handleTitleChange = (event) => {
        setNewTitle(event.target.value);
    };

    const handlePostClick = (post) =>{
        setSelectPost(post);
    }

    const handleChangeFirstPost = () => {
        const updatedPosts = [...posts];
        updatedPosts[0].title = newTitle;
        setPosts(updatedPosts);
    };

    return (
        <div>
            <h1>Dashboard</h1>
            <input type="text" value={newTitle} onChange={handleTitleChange} />
            <button onClick={handleChangeFirstPost}>Update Title</button>
            <Posts posts={posts}  onPostClick = {handlePostClick}/>
            <PostDetail post={selectPost} ></PostDetail>
        </div>
    );
};

export default Dashboard;