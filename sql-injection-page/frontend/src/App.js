import React, {useState} from 'react';

import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Box from '@material-ui/core/Box';
import { Paper, Typography } from '@material-ui/core';

const axios = require('axios')

function App() {

  // state declarations
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")
  const [message, setMessage] = useState(false)
  const [invalidLogin, setInvalidLogin] = useState(false)

  const HandleSubmit = (e, props) => {
    e.preventDefault()
    alert(username + " with password " + password + " was submitted ")
    axios.post('http://localhost:8080/inject', {
        username: username,
        password: password }
      )
      .then(response => {
         if (response.data.username != null) { 
          setUsername(response.data.username)
          setPassword(response.data.password)
          setMessage(true)
         } else {
           setInvalidLogin(true)
         }
      })
}

return (
    <Grid 
      container
      direction="column"
      justify="center"
      alignItems="center"
      spacing={5}
      >
        <Grid item xs={12}>
          <Typography variant="h2" align="center"> Welcome to the SQL Injection Test Page</Typography>
        </Grid>
       <Paper elevation={3}>
       <Box p={6}>

        <Grid item xs={12}>
            <Grid
                container
                direction="column"
                justify="center"
                alignItems="center"
                spacing={2}
                >
                  <form onSubmit={HandleSubmit}>
                      <Grid item xs={12}>
                          <TextField
                              fullWidth 
                              label="Username" 
                              name="Username" 
                              variant="outlined" 
                              onChange={function(e) {
                                  setUsername(e.target.value)
                                  }
                                }
                              />
                      </Grid>
                      <br />
                      <Grid item xs={12}>
                          <TextField
                              fullWidth
                              label="Password" 
                              name="password" 
                              variant="outlined"
                              type="password" 
                              onChange={(e)=> setPassword(e.target.value)}
                              />
                      </Grid>
                      <Grid item xs={12}>
                          <br />
                          <Grid 
                              container
                              justify="space-between"
                              >
                                <Grid item>
                                        <Button variant="contained" color="primary" type="submit" value="Submit">
                                          Login
                                        </Button>
                                </Grid> 
                                <Grid item>
                                        <Button 
                                            variant="contained" 
                                            color="secondary" 
                                            type="reset"
                                            onClick={() => {
                                                setMessage(false)
                                                setUsername("")
                                                setPassword("")
                                                setInvalidLogin(false)
                                              }}
                                            >
                                          Clear
                                        </Button>
                                </Grid>
                          </Grid>
                      </Grid> {/* terminates the third item */}
                  </form>
            </Grid> {/* terminates the parent Grid container */}
        </Grid> {/* terminates the Grid item */}
        </Box>
        </Paper>
        <Grid item>
          { 
            username.includes("' OR '1'='1") ?
            <Paper>
              <Box p={1} bgcolor="grey.300">
                <Typography variant="h3">SQL Injection command: {username}</Typography>
              </Box>
            </Paper>
             : 
            password.includes("' OR '1'='1") ? 
              <Paper>
                <Box p={1} bgcolor="grey.300">
                  <Typography variant="h3"> SQL Injection command: {password} </Typography> 
                </Box>
              </Paper> 
            : null
          }
        </Grid>
        <Grid item>
            <Grid
                direction="column"
                justify="center"
                alignItems="center"                 
            >
                { message ? 
                  <div>
                   <Paper>
                      <Box p={2} bgcolor="blue">
                          <Typography variant="h4">Username: {username}</Typography>
                          <Typography variant="h4">Password: {password}</Typography>
                      </Box>
                   </Paper>
                  </div> 
                  : invalidLogin ? 
                    <Paper>
                      <Box p={1} bgcolor="red">
                        <Typography variant="h3"> Invalid Login!!! </Typography> 
                      </Box>
                    </Paper> 
                      :
                  null
                }

            </Grid>
        </Grid>
    </Grid>

  );
}

export default App;



