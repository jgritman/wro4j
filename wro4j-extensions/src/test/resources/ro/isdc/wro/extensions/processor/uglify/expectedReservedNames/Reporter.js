function Reporter(a,b){this.messages=[],this.stats=[],this.lines=a,this.ruleset=b}Reporter.prototype={constructor:Reporter,error:function(a,b,c,d){this.messages.push({type:"error",line:b,col:c,message:a,evidence:this.lines[b-1],rule:d||{}})},warn:function(a,b,c,d){this.report(a,b,c,d)},report:function(a,b,c,d){this.messages.push({type:this.ruleset[d.id]==2?"error":"warning",line:b,col:c,message:a,evidence:this.lines[b-1],rule:d})},info:function(a,b,c,d){this.messages.push({type:"info",line:b,col:c,message:a,evidence:this.lines[b-1],rule:d})},rollupError:function(a,b){this.messages.push({type:"error",rollup:!0,message:a,rule:b})},rollupWarn:function(a,b){this.messages.push({type:"warning",rollup:!0,message:a,rule:b})},stat:function(name,value){this.stats[name]=value}},CSSLint._Reporter=Reporter