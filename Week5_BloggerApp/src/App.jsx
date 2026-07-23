import React from "react";

import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

import { books, blogs, courses } from "./Components/Data";

function App() {

    const showBooks = true;
    const showBlogs = true;
    const showCourses = true;

    return (

        <div
            style={{
                display: "flex",
                justifyContent: "space-around"
            }}
        >

            {

                showCourses &&
                <CourseDetails courses={courses} />

            }

            {

                showBooks &&
                <BookDetails books={books} />

            }

            {

                showBlogs &&
                <BlogDetails blogs={blogs} />

            }

        </div>

    );

}

export default App;