function r(){let e=JSON.parse(localStorage.getItem("user"));return e&&e.access_token?{Authorization:"Bearer "+e.access_token}:{}}export{r as a};
